package io.blushine.android.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import androidx.annotation.Nullable;

import io.blushine.android.AppActivity;

/**
 * Display a progress bar in the main window
 */
public class ProgressBar {
/** Current progress bar */
private static ProgressDialog mProgressDialog = null;

/**
 * Show the progress bar (as a spinner)
 */
public static void show() {
	show(Styles.SPINNER, null, null);
}

/**
 * Show the progress bar
 * @param style the type of the progress bar
 * @param title the title of the progress bar, may be null
 * @param message the message to display on the progress bar, may be null
 */
public static void show(Styles style, @Nullable String title, @Nullable String message) {
	show(style, title, message, false, null);
}

/**
 * Show the progress bar
 * @param style the type of the progress bar
 * @param title the title of the the progress bar, may be null
 * @param message the message to display on the progress bar, may be null
 * @param cancelable set to true if the user should be able to cancel_selectable the progress
 * @param cancelListener the listener if this progress bar is canceled
 */
public static void show(Styles style, @Nullable String title, @Nullable String message, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
	// Hide existing
	hide();

	// Create new
	mProgressDialog = new ProgressDialog(AppActivity.getActivity());
	if (style != null) {
		mProgressDialog.setProgressStyle(style.getId());
	}
	if (title != null && !title.isEmpty()) {
		mProgressDialog.setTitle(title);
	}
	if (message != null && !message.isEmpty()) {
		mProgressDialog.setMessage(message);
	}
	mProgressDialog.setCancelable(cancelable);
	mProgressDialog.setOnCancelListener(cancelListener);
	mProgressDialog.show();
}

public static void hide() {
	if (mProgressDialog != null) {
		mProgressDialog.dismiss();
		mProgressDialog = null;
	}
}

/**
 * The progress bar styles
 */
public enum Styles {
	SPINNER(ProgressDialog.STYLE_SPINNER),
	HORIZONTAL(ProgressDialog.STYLE_HORIZONTAL),;
	private int mId;

	/**
	 * Set the id of the style
	 * @param id progress styles
	 */
	Styles(int id) {
		mId = id;
	}

	/**
	 * @return id of the style
	 */
	private int getId() {
		return mId;
	}
}
}
