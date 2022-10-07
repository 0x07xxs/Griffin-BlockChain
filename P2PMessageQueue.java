/**
 * This Queue maintains the queue of messages coming from connected clients.
 */
public class P2PMessageQueue {

    private P2PMessage head = null;
    private P2PMessage tail = null;


    /**
     * This method allows adding a message object to the existing queue.
     * @param oMessage
     */
    public synchronized void enqueue(P2PMessage oMessage){
        // Checks for head and tail equal to null and assigns value to oMessage
        if (head == null && tail == null){
            head = oMessage;
            head.next = null;
            tail = oMessage;
            tail.next = null;
        }

        else{
            tail.next = oMessage;
            tail = oMessage;
        }
    }


    /**
     * This method allows removing a message object from the existing queue.
     * @return
     */
    public synchronized P2PMessage dequeue(){
        P2PMessage oP2PHead;
        oP2PHead = head;
        // Checks for empty queue
        if (head == null && tail == null){
            System.out.println("Queue is empty and can't be dequeued");
        }
        // Checks if head and tail are equal and sets them to null
        else if(head == tail){
            head = null;
            tail = null;
        }

        else{
            head = head.next;
        }
        return oP2PHead;
    }

    // Checks for nodes
    public boolean hasNodes(){
        if(head != null){
            return true;
        }
        else{
            return false;
        }
    }
}

