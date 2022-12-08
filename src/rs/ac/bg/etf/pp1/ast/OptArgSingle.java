// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class OptArgSingle extends ListOfOptParams {

    private OptArg OptArg;

    public OptArgSingle (OptArg OptArg) {
        this.OptArg=OptArg;
        if(OptArg!=null) OptArg.setParent(this);
    }

    public OptArg getOptArg() {
        return OptArg;
    }

    public void setOptArg(OptArg OptArg) {
        this.OptArg=OptArg;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptArg!=null) OptArg.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptArg!=null) OptArg.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptArg!=null) OptArg.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptArgSingle(\n");

        if(OptArg!=null)
            buffer.append(OptArg.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptArgSingle]");
        return buffer.toString();
    }
}
