#include <vector>
#include <iostream>

using namespace std;

class Node {
    public:
        int data;
        Node *next;

        Node (int data) {
            this->data = data;
            this->next = NULL;
        }
};

class Solution {
    public:
        Node * removeDuplicates(Node * head) {
            Node *current, *last;
            if (head == NULL) {
                return NULL;
            }
            last = head;
            current = head->next;
            while (current != NULL) {
                if (last->data != current->data) {
                    last->next = current;
                    last = last->next;
                }
                current = current->next;
            }
            last->next = NULL;
            return head;
        }


        Node * insert(Node *head, int data) {
            Node *p = new Node(data);
            if (head == NULL){
                head = p;
            } else if(head->next == NULL) {
                head->next = p;
            } else {
                Node *start = head;
                while (start->next != NULL) {
                    start = start->next;
                }
                start->next = p;
            }
            return head;
        }


        void display(Node *head) {
            Node *start = head;
            while (start) {
                cout << start->data << " ";
                start = start->next;
            }
        }
};

int main() {
    Node *head = NULL;
    Solution mylist;
    int T, data;
    cin >> T;
    while (T-- > 0) {
        cin >> data;
        head = mylist.insert(head, data);
    }
    head = mylist.removeDuplicates(head);
    mylist.display(head);
}
