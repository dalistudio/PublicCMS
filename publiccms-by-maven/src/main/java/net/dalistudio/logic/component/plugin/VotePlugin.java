package net.dalistudio.logic.component.plugin;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.spi.Pluginable;
import net.dalistudio.logic.service.plugin.PluginVoteService;
import com.wangdali.common.base.Base;

@Component
public class VotePlugin extends Base implements Pluginable {
    public static final String CODE = "vote";
    @Autowired
    private PluginVoteService pluginVoteService;

    @Override
    public String getCode() {
        return CODE;
    }

    @Override
    public boolean supportWidget() {
        return true;
    }

    @Override
    public String dealWidget(String... args) {
        if (notEmpty(args)) {
            Set<Integer> ids = new HashSet<Integer>();
            for (String arg : args) {
                try {
                    ids.add(Integer.parseInt(arg));
                } catch (NumberFormatException e) {

                }
            }
            pluginVoteService.getEntitys(ids.toArray(new Integer[ids.size()]));
        }
        return "";
    }
}