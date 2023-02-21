package cn.lp.rocketmq.common;

public enum SendStatus {
    SEND_OK, // 发送成功
    FLUSH_DISK_TIMEOUT,  // 刷盘超时。当Broker设置的刷盘策略为同步刷盘时才可能出现这种异常状态。异步刷盘不会出现
    FLUSH_SLAVE_TIMEOUT, // Slave同步超时。当Broker集群设置的Master-Slave的复制方式为同步复制时才可能出现这种异常状态。异步复制不会出现
    SLAVE_NOT_AVAILABLE, // 没有可用的Slave。当Broker集群设置为Master-Slave的复制方式为同步复制时才可能出现这种异常状态。异步复制不会出现
}
