package sk.sorien.silexplugin.pimple;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementPresentation;
import org.jetbrains.annotations.NotNull;
import sk.sorien.silexplugin.SilexIcons;

public class ParameterLookupElement extends LookupElement {

    private final Parameter parameter;
    public ParameterLookupElement(Parameter parameter) {
        this.parameter = parameter;
    }

    @NotNull
    @Override
    public String getLookupString() {
        return parameter.getName();
    }

    public void renderElement(LookupElementPresentation presentation) {

        presentation.setItemText(getLookupString());
        presentation.setTypeText(parameter.getType());

        if (!parameter.getValue().isEmpty())
            presentation.appendTailText("(" + parameter.getValue() + ")", true);

        presentation.setIcon(SilexIcons.Parameter);
    }
}