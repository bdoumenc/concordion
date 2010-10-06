package org.concordion.api.extension;

/**
 * Supplements Concordion behaviour by adding new commands, listeners or output enhancements.
 * <p>
 * To use extensions, set the system property <code>concordion.extensions</code> to a comma-separated list of the 
 * fully-qualified class name of the extensions to be installed.  All extensions must be present on the classpath 
 * and must implement <code>org.concordion.api.extension.ConcordionExtension</code>.
 */
public interface ConcordionExtension {
    void addTo(ConcordionExtender concordionExtender);
}
