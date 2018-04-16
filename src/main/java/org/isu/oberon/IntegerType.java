package org.isu.oberon;
import org.bytedeco.javacpp.LLVM;
import org.bytedeco.javacpp.LLVM.*;
import static org.bytedeco.javacpp.LLVM.*;

public class IntegerType extends NumberType {
    IntegerType(){
        super("INTEGER");
    }

    public ArithValue infixOp(EvalStruct s, ArithValue arg1, int op, ArithValue arg2)
    {
        LLVMValueRef res;
        switch (op) {
            case org.isu.oberon.ExprParser.PLUS:
                res = LLVMBuildAdd(s.builder, arg1.ref, arg2.ref, "");
                break;
            case org.isu.oberon.ExprParser.MINUS:
                res = LLVMBuildSub(s.builder, arg1.ref, arg2.ref, "");
                break;
            case org.isu.oberon.ExprParser.MUL:
                res =  LLVMBuildMul(s.builder, arg1.ref, arg2.ref, "");
                break;
            case org.isu.oberon.ExprParser.DIV:
                res = LLVMBuildSDiv(s.builder, arg1.ref, arg2.ref, ""); // FIXME: Signed op.
                break;
            default:
                System.out.println("Wrong Operation!");
                System.exit(1);
                return null;
        }
        return new ArithValue(this, res); // Should not get here
    }

}
