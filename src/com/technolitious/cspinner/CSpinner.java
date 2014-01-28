/**
 * 
 */
package com.technolitious.cspinner;

import java.lang.reflect.Field;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.Spinner;

/**
 * @author muhammadali
 * 
 */
public class CSpinner extends Spinner {

	static Field field = null;
	static {
		try {
			field = AdapterView.class.getDeclaredField("mOldSelectedPosition");
			field.setAccessible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param context
	 */
	public CSpinner(Context context) {
		super(context);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public CSpinner(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public CSpinner(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void setSelection(int position) {
		if (null != field) {
			try {
				field.set(this, -1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		super.setSelection(position);
	}

}
