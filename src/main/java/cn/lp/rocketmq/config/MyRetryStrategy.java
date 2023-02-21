//package cn.lp.rocketmq.config;
//
//class MyRetryStrategy implements MessageRetryStrategy {
//    @Override
//    public long nextDelayTimeMillis(int retryTimes, Message message, Object context) {
//        switch (retryTimes) {
//            case 1:
//                return 1000L;
//            case 2:
//                return 30000L;
//            case 3:
//                return 60000L;
//            default:
//                return -1;
//        }
//    }
//}
