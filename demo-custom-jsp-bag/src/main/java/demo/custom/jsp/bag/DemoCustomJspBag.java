package demo.custom.jsp.bag;

/**
 * @author Urva Patel
 */
import com.liferay.portal.deploy.hot.CustomJspBag;
import com.liferay.portal.kernel.url.URLContainer;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;


@Component(
	immediate = true,
	property = {
			"context.id=DemoCustomJspBag",
	        "context.name=Demo Custom JSP Bag",
	    	"service.ranking:Integer=100"
	}
)
public class DemoCustomJspBag implements CustomJspBag {
	
	private Bundle bundle;
	private List<String> customJsps;

	/**
	 * @return the folder path in your module’s JAR where the JSPs reside 
	 */
	@Override
	public String getCustomJspDir() {
		System.out.println("DemoCustomJspBag >>> getCustomJspDir() >>> Inside");
		return "META-INF/jsps/";
	}

	/**
	 * @return adds the URL paths of Journal Article JSP when the module is activated.
	 * @param bundleContext
	 */
	@Activate
	protected void activate(BundleContext bundleContext) {
		bundle = bundleContext.getBundle();

		customJsps = new ArrayList<>();

		Enumeration<URL> entries = bundle.findEntries(
			getCustomJspDir(), "*.jsp", true);

		while (entries.hasMoreElements()) {
			URL url = entries.nextElement();
			customJsps.add(url.getPath());
		}
	}
	
	/**
	 * @return the list of this module’s journal article JSP URL path
	 */
	@Override
	public List<String> getCustomJsps() {
		System.out.println("DemoCustomJspBag >>> getCustomJsps() >>> Inside");
	    return customJsps;
	}

	@Override
	public URLContainer getURLContainer() {
		System.out.println("DemoCustomJspBag >>> getURLContainer() >>> Inside");
		return urlContainer;
	}

	@Override
	public boolean isCustomJspGlobal() {
		System.out.println("DemoCustomJspBag >>> isCustomJspGlobal() >>> Inside");
		return true;
	}
	
	private final URLContainer urlContainer = new URLContainer() {

		/**
		 * @return one specific resource by the path name included
		 */
	    @Override
	    public URL getResource(String name) {
	        return bundle.getEntry(name);
	    }

	    /**
	     *  looks up all the paths to resources in the container by a given path. 
	     * @return HashSet of Strings for the matching Journal Article JSP path
	     */
	    @Override
	    public Set<String> getResources(String path) {
	        Set<String> paths = new HashSet<>();

	        for (String entry : customJsps) {
	            if (entry.startsWith(path)) {
	               paths.add(entry);
	            }
	        }

	        return paths;
	    }

	};

}