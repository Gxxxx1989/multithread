synchronized 底层实现
JDK 早期实现比较重量级 -OS 操作系统级别 效率特别低
改进：锁升级

synchronized(Object)
是可冲入锁，在同一线程
MarkWord 记录这个线程Id（偏向锁）单个线程执行情况
如果有线程争用 升级为自旋锁（默认旋转10次，如果得不到锁）
升级为重量级锁 -OS 线程成为block状态，不占用cpu资源
锁只能升级，不能降级。
Synchronized 速度得到提升 
自旋锁使用率比较高（不经过OS）
执行时间长或者线程数比较多情况用OS锁 其他用自旋锁
Synchronized（对象不能用String常量 Integer Long）"# multithread" 
