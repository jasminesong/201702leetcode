// 369. Plus One Linked List Add to List
// Description  Submission  Solutions
// Total Accepted: 11968
// Total Submissions: 22443
// Difficulty: Medium
// Contributors: Admin
// Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

// You may assume the integer do not contain any leading zero, except the number 0 itself.

// The digits are stored such that the most significant digit is at the head of the list.

// Example:
// Input:
// 1->2->3

// Output:
// 1->2->4


//====================================================
//思想是：翻转原来的链表，从个位开始向前处理，每一位如果是9前进位是1，如果不是9且进位为0，1的情况。
//最后再将处理了好的链表翻转回来，如果添了一个高位1，
//则在链表头加一个val为1的新节点
//=====================================================
public class Solution {
	public ListNode plusOne(ListNode head){
		ListNode p = reverseList(head);
		ListNode end = p;
		int add = 1;
		while(p != null){
			if(p.val == 9 && add == 1){
				p.val = 0;
			}else if(p.val != 9){
				if(add == 1){
					p.val = p.val + 1;
				}
				add = 0;
			}
			p = p.next;
		}

		ListNode start = reverseList(end);
		if(add == 1){
			ListNode newHead = new ListNode(1);
			newHead.next = start;
			return newHead;
		}
		return start;
	}

	public ListNode reverseList(ListNode head){   //我自己翻转链表的成熟版本
		if(head == null || head.next == null){
			return head;
		}

		ListNode second = head.next;
		ListNode third = second.next;

		second.next = head;
		head.next = null;
		while(third != null){
			head = second;
			second = third;
			third = third.next;
			second.next = head;
		}
		return second;
    }