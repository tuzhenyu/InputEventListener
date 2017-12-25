package iel.tzy.watcher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/**
 * Created by tuzhenyu on 2017/12/21.
 */

public class TEditText extends android.support.v7.widget.AppCompatEditText {

    private TInputConnection inputConnection;

    public TEditText(Context context) {
        super(context);
        init();
    }

    public TEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        inputConnection = new TInputConnection(null,true);
    }


    /**
     * 当输入法和EditText建立连接的时候会通过这个方法返回一个InputConnection。
     * 我们需要代理这个方法的父类方法生成的InputConnection并返回我们自己的代理类。
     * */
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        inputConnection.setTarget(super.onCreateInputConnection(outAttrs));
        return inputConnection;
    }

    public void setBackSpaceLisetener(TInputConnection.BackspaceListener backSpaceLisetener){
        inputConnection.setBackspaceListener(backSpaceLisetener);
    }
}
