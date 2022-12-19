package io.jenkins.plugins.analysis.warnings;

import org.kohsuke.stapler.DataBoundConstructor;
import org.jenkinsci.Symbol;
import hudson.Extension;

import io.jenkins.plugins.analysis.core.model.AnalysisModelParser;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisLabelProvider;
import io.jenkins.plugins.analysis.core.model.SvgIconLabelProvider;

/**
 * Provides a parser and customized messages for Polyspace tool.
 *
 * @author Eva Habeeb
 */
public class PolyspaceParse extends AnalysisModelParser {
    private static final long serialVersionUID = 5776036181982740586L;
    private static final String ID = "PolyspaceParse";
    private static final String ICON_NAME = "polyspace";

    /** Creates a new instance of {@link PolyspaceParse}. */
    @DataBoundConstructor
    public PolyspaceParse() {
        super();
        // empty constructor required for stapler
    }

    /** Descriptor for this static analysis tool. */
    @Symbol("PolyspaceParse")
    @Extension
    public static class Descriptor extends AnalysisModelParserDescriptor {
        /** Creates the descriptor instance. */
        public Descriptor() {
            super(ID);
        }

        @Override
        public StaticAnalysisLabelProvider getLabelProvider() {
            return new SvgIconLabelProvider(getId(), getDisplayName(), getDescriptionProvider(), ICON_NAME);
        }
    }
}
