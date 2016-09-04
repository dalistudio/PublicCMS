package net.dalistudio.common.spi;

import java.util.List;
import java.util.Locale;

import net.dalistudio.views.pojo.ExtendField;

public interface Configable {
    public static final String CONFIGPREFIX = "config.";

    public String getCode();

    public String getSubcodeDescription(String subcode, Locale locale);

    public List<String> getSubcode(int siteId);

    public List<ExtendField> getExtendFieldList(String subcode, Locale locale);
}