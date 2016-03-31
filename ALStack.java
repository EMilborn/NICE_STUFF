import java.util.ArrayList;    
class ALStack<T> implements Stack<T>{
    
    ArrayList<T> _stack;

    public ALStack(){
	_stack = new ArrayList<T>();
    }

    public boolean isEmpty(){
	return _stack.size() == 0;
    }

    private int size(){
	return _stack.size();
    }

    public T peek(){
	return _stack.get(size()-1);
    }

    public T pop(){
	return _stack.remove(size()-1);
    }

    public void push (T x){
	_stack.add(x);
    }
    
}
