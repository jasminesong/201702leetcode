//328. Odd Even Linked List Add to List
//Description  Submission  Solutions
//Total Accepted: 58267
//Total Submissions: 137850
//Difficulty: Medium
//Contributors: Admin
//Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
//
//You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
//
//Example:
//Given 1->2->3->4->5->NULL,
//return 1->3->5->2->4->NULL.
//
//Note:
//The relative order inside both the even and odd groups should remain as it was in the input. 
//The first node is considered odd, the second node even and so on ...




//=========================================
//思路就是，添加指针，通过指针的巧妙移动，来转换顺序
//=========================================

public class Solution{
    public ListNode oddEvenList(ListNode head){
        if(head == null){
            return head;
        }
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode oddHead = p1;
        ListNode evenHead = p2;
        
        while(p1.next != null && p2.next != null){
            p1.next = p2.next; //第1个点连上第3个点
            p1 = p1.next; //第1个点的指针P1移到第3个点
            p2.next = p1.next; // 第二个点连上第3个点后面的点，也就是第4个点
            p2 = p2.next;  //第2个点的指针，挪动到第4个点上
        } 
        
        p1.next = evenHead;  //p1是奇点序列的最后一个点，让它连上偶序列的第一个点
        return oddHead;
    }
}

//还有一个思路，就是让偶数点，全部连到序列的最后一个点上去
//这也是一个比较常见的思路