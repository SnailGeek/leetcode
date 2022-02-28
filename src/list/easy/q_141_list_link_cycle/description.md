# 拓展
如果这个不只是判断是否存在循环，而是找到第一个循环的节点，该如何处理呢？

1. 先找出快慢两个节点相遇的那个节点node
2. 再重新定义两个指针，其中一个指针p1固定不动，另外一个指针p2遍历链表，终止条件是p2第二次遍历到node的时候
p1和p2都不相同，则p1 指向p1.next, 如果再第二次遍历到node之前两个指针指向的节点相等，则该节点即为循环起始节点

伪代码：
```
ListNode p1 = head, p2=head;
int count = 0;
while(p1 != node){
    while(count != 2){
        if(p2 == node){
            count++;
        }
        if(p1 == p2){
            return p1;
        }
    }
}
```