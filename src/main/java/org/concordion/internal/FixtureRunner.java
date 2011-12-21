package org.concordion.internal;

import java.io.IOException;

import org.concordion.api.FullOGNL;
import org.concordion.api.ResultSummary;
import org.concordion.internal.extension.FixtureExtensionLoader;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class FixtureRunner {

    private FixtureExtensionLoader fixtureExtensionLoader = new FixtureExtensionLoader();

    public ResultSummary run(final Object fixture, final Context appContext) throws IOException, NameNotFoundException {
        Log.i("CONCORDION", "Starting up...");
        Context context = appContext.createPackageContext("com.example.tests.acceptance",
                    Context.CONTEXT_IGNORE_SECURITY | Context.CONTEXT_INCLUDE_CODE);

        ConcordionBuilder concordionBuilder = new ConcordionBuilder(context);
        if (fixture.getClass().isAnnotationPresent(FullOGNL.class)) {
            concordionBuilder.withEvaluatorFactory(new OgnlEvaluatorFactory());
        }
        fixtureExtensionLoader.addExtensions(fixture, concordionBuilder);
        ResultSummary resultSummary = concordionBuilder.build().process(fixture, context);
        resultSummary.print(System.out, fixture);
        resultSummary.assertIsSatisfied(fixture);
        return resultSummary;
    }
}