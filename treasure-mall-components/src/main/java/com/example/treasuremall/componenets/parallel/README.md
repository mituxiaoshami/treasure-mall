# 并发执行器

## fork/join

forkjoin包是对fork/join框架的封装，并且提供组件

Fork/Join框架是Java 7提供的一个用于并行执行任务的框架，是一个把大任务分割成若干个小任务，最终汇总每个小任务结果后得到大任务结果的框架。

Fork就是把一个大任务切分为若干子任务并行的执行，Join就是合并这些子任务的执行结果，最后得到这个大任务的结果。

在企业级的应用中有以下几个方面：

1. 批量查询：比如大批量根据id查询商品(id肯定是去重过的)，大批量根据某个条件查询等等批量查询，提高查询效率
2. 批量操作：针对互不影响的数据，可以用fork/join进行并发执行，提高效率

