


// 203. Remove Linked List Elements Add to List
// Description  Submission  Solutions
// Total Accepted: 100114
// Total Submissions: 320272
// Difficulty: Easy
// Contributors: Admin
// Remove all elements from a linked list of integers that have value val.

// Example
// Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
// Return: 1 --> 2 --> 3 --> 4 --> 5



public class Solution {
	public ListNode remove Elements(ListNode head,int val){
		if(head == null){
			return head;
		}

		ListNode p1 = new ListNode(0);
		p1.next = head;
		ListNode p3 = p1;
		ListNode p2 = head;
		while(p2 != null){
			if(p2.val == val){
				p1.next = p2.next;
			}else{
				p1 = p1.next;
			}
			p2 = p2.next;
		}
		return p3.next;
	}
}