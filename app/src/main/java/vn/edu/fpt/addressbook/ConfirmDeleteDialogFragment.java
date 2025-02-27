package vn.edu.fpt.addressbook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ConfirmDeleteDialogFragment extends DialogFragment {

    private OnDeleteListener listener;

    public static ConfirmDeleteDialogFragment newInstance(OnDeleteListener listener) {
        ConfirmDeleteDialogFragment fragment = new ConfirmDeleteDialogFragment();
        fragment.listener = listener;
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireActivity())
                .setTitle("Xác nhận xóa")
                .setMessage("Bạn có chắc muốn xóa không?")
                .setPositiveButton("Xóa", (dialog, which) -> {
                    if (listener != null) listener.onDeleteConfirmed();
                })
                .setNegativeButton("Hủy", null)
                .create();
    }

    public interface OnDeleteListener {
        void onDeleteConfirmed();
    }
}

