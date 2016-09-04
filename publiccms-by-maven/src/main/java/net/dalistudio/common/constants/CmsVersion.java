package net.dalistudio.common.constants;

import java.util.UUID;

public class CmsVersion {
    private static final String clusterId = UUID.randomUUID().toString();
    private static boolean master = false;

    /*
     * 获得软件版本
     */
    public static final String getVersion() {
        return "V2016.0808";
    }

    /*
     * 获得集群的编号
     */
    public static final String getClusterId() {
        return clusterId;
    }

    /*
     * 是否管理节点
     */
    public static boolean isMaster() {
        return master;
    }

    /*
     * 设置管理节点
     */
    public static void setMaster(boolean master) {
        CmsVersion.master = master;
    }
}