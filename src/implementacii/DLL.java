package implementacii;

public class DLL <E>{
    private DLLNode<E> first, last;
    public DLL(){
        this.first=null;
        this.last=null;
    }

    public void insertFirst(E o){
        DLLNode<E> ins = new DLLNode<E>(o,null,first);
        if(first==null) last= ins;
        else first.pred = ins;
        first = ins;
    }

    public void insertLast(E o){
        if(first==null) insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after){
        if(after==last){
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o,after, after.succ);
        after.succ.pred=ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before){
        if(before == first){
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o,before,before.succ);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst(){
        if(first!=null){
            DLLNode<E> tmp = first;
            first = first.succ;
            first.pred = null;
            if(first==null) last = null;
            return tmp.element;
        }
        else return null;
    }
    public E deleteLast(){
        if(first!=null){
            if(first.succ==null)return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last= last.pred;
                last.succ = null;
                return tmp.element;
            }
        }else return null;
    }

    public E delete(DLLNode<E> node){
        if(node == first){
            deleteFirst();
            return node.element;
        }
        if(node==last){
            deleteFirst();
            return node.element;
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;
    }

    public DLLNode<E> getFirst(){
        return first;
    }

    public DLLNode<E> getLast(){
        return last;
    }

}
