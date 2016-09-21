package gui.menu;
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import model.BlankSlot;
import model.CommentSlot;
import model.ExprSlot;
import model.Slot;
import model.SlotList;
import util.XLException;
import expr.Expr;
import expr.ExprParser;

public class XLBufferedReader extends BufferedReader {
        public XLBufferedReader(String name) throws FileNotFoundException {
                super(new FileReader(name));
        }
 
        public void load(SlotList slotList) {
                try {
                        while (ready()) {
                                String string = readLine();
                                int i = string.indexOf('=');
                                // TODO
                                String slotName = string.substring(0, i);
                                String exprName = string.substring(i + 1);
                                Slot slot = null;                              
                                if (exprName.startsWith("#")) {
                                        slot = new CommentSlot(exprName);
                                }
                                else if (exprName.length() == 0) {
                                        slot = new BlankSlot();
                                }                              
                                else {
                                        ExprParser parser = new ExprParser();                          
                                        slot = new ExprSlot(parser.build(exprName));
                                }
                                slotList.input(exprName, slotName);
                        }
                } catch (Exception e) {
                        throw new XLException(e.getMessage());
                }
        }
}