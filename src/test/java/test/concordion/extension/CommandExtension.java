package test.concordion.extension;

import org.concordion.api.Command;
import org.concordion.api.CommandCall;
import org.concordion.api.Evaluator;
import org.concordion.api.ResultRecorder;
import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;

public class CommandExtension implements ConcordionExtension {

    public void addTo(ConcordionExtender concordionExtender) {
        concordionExtender.withCommand("http://myorg.org/my/extension", "log", new Command() {
            
            public void verify(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
            }
            
            public void setUp(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
            }
            
            public void execute(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
                System.out.println(commandCall.getElement().getText());
            }
        });
    }
}
