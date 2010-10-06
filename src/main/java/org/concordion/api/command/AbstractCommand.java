package org.concordion.api.command;

import org.concordion.api.Command;
import org.concordion.api.CommandCall;
import org.concordion.api.Evaluator;
import org.concordion.api.ResultRecorder;

public abstract class AbstractCommand implements Command {

    public void execute(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
    }

    public void setUp(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
    }

    public void verify(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
    }
}
