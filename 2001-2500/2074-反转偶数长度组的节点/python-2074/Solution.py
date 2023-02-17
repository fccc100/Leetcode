class Solution:
    def reverseEvenLengthGroups(self, head: Optional[ListNode]) -> Optional[ListNode]:
        groupList = []
        groupList.append(head)
        idx, cnt = 1, 1
        while head is not None:
            head = head.next
            if head is None:
                break
            if idx == cnt:
                groupList.append(head)
                idx = 1
                cnt += 1
            else:
                idx += 1

        for i in range(len(groupList) - 1):
            h = groupList[i]
            last, c = h, i + 1
            while c > 1:
                last = last.next
                c -= 1
            last.next = None

        for i in range(len(groupList)):
            if i == len(groupList) - 1:
                count, node = 0, groupList[i]
                while node is not None:
                    count += 1
                    node = node.next
                if count % 2 == 0:
                    rev_node = self.reverseList(groupList[i], i + 1)
                    groupList[i] = rev_node
            else:
                if i % 2 == 1:
                    rev_node = self.reverseList(groupList[i], i + 1)
                    groupList[i] = rev_node

        for i in range(len(groupList) - 1):
            h = groupList[i]
            last, c = h, i + 1
            while c > 1:
                last = last.next
                c -= 1
            last.next = groupList[i + 1]

        return groupList[0]

    def reverseList(self, head, cnt):
        if cnt == 0 or head is None or head.next is None:
            return head
        rev_node = self.reverseList(head.next, cnt - 1)
        head.next.next = head
        head.next = None
        return rev_node
