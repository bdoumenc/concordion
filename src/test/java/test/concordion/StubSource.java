package test.concordion;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.concordion.api.Resource;
import org.concordion.api.Source;
import org.concordion.internal.util.Check;

public class StubSource implements Source {

    private static final String STUB_RESOURCE_ORIGIN = "stub";
    
	// FUTURE: Could change this to byte[] instead of String - to handle binary resources.
    private Map<Resource, String> resources = new HashMap<Resource, String>();

    public void addResource(String resourceName, String content) {
        addResource(stubbedResource(resourceName), content);
    }

    public void addResource(Resource resource, String content) {
        resources.put(resource, content);
    }

    public InputStream createInputStream(Resource resource) throws IOException {
        Check.isTrue(canFind(resource), "Resource '" + resource.getPath() + "' has not been stubbed in the simulator.");
        return new ByteArrayInputStream(resources.get(resource).getBytes("UTF-8"));
    }

    public boolean canFind(Resource resource) {
        return resources.containsKey(resource);
    }
    
    private static Resource stubbedResource(String resourceName) {
    	return new Resource(STUB_RESOURCE_ORIGIN, resourceName);
    }
}
