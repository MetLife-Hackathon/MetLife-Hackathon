import { useAlertDialogStore, useConfirmDialogStore } from '@/store/common/dialog';
import { DialogProps } from '@mui/material';
import { AlertModel, ConfirmModel } from '@/model/common/dialog';

const useDialog = () => {
  const { addAlertDialogModel } = useAlertDialogStore();
  const { addDConfirmDialogModel } = useConfirmDialogStore();

  const alert = async (content: string, dialogProps?: DialogProps) => {
    const onClickOK = (func: (value: boolean) => void) => {
      func(true);
    };

    return new Promise((resolve) => {
      addAlertDialogModel(AlertModel.new(content, () => onClickOK(resolve), dialogProps));
    });
  };

  const confirm = async (content: string, dialogProps?: DialogProps) => {
    const onClickConfirm = (func: (value: boolean) => void, value: boolean) => {
      func(value);
    };

    return new Promise((resolve) => {
      addDConfirmDialogModel(
        ConfirmModel.new(content, (value: boolean) => onClickConfirm(resolve, value), dialogProps),
      );
    });
  };

  return {
    alert,
    confirm,
  };
};

export default useDialog;
