// generated with ast extension for cup
// version 0.8
// 14/8/2022 6:31:2


package rs.ac.bg.etf.pp1.ast;

public class NoBody extends ClassBody {

    public NoBody () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoBody(\n");

        buffer.append(tab);
        buffer.append(") [NoBody]");
        return buffer.toString();
    }
}
