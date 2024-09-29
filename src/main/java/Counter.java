public class Counter implements AutoCloseable{
    int count;

    public void add(){
        count++;
    }
    public void out(){
        count--;
    }
    public int resultCount(){
        return count;
    }
    public Integer totalCount(int total){
        return count = total;
    }



    @Override
    public void close() throws Exception {
        System.out.println("Количество животных: " + count);
    }
}
