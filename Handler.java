abstract class Handler {
    protected Handler successor;
    public Handler(Handler successor){
        this.successor=successor;
    }


}
