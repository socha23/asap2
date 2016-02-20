package pl.socha23.asap.assets;

import com.google.common.base.Charsets;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.servlets.assets.AssetServlet;

import java.net.URL;

/**
 * Assets bundle that delegates all non-file paths to the index file
 */
public class OnePageAppAssetsBundle extends AssetsBundle {

    private String defaultPath;

    public OnePageAppAssetsBundle(String resourcePath, String uriPath, String indexFile) {
        super(resourcePath, uriPath, indexFile);
        this.defaultPath = resourcePath.substring(1) + "/" + indexFile;
    }

    protected AssetServlet createServlet() {
        return new OnePageAppAssetServlet();
    }

    private class OnePageAppAssetServlet extends AssetServlet {
        public OnePageAppAssetServlet() {
            super(getResourcePath(), OnePageAppAssetsBundle.this.getUriPath(), OnePageAppAssetsBundle.this.getIndexFile(), Charsets.UTF_8);
        }

        protected URL getResourceUrl(String absoluteRequestedResourcePath) {
            return super.getResourceUrl(substituteIndexFile(absoluteRequestedResourcePath));
        }

    }

    protected String substituteIndexFile(String aPath) {
        if (aPath.contains(".")) {
            // if it has dots, we consider it a file, and don't do substitution
            return aPath;
        }
        return defaultPath;
    }
}

