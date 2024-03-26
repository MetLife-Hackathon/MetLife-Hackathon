import { DialogProps } from '@mui/material';

class AlertModel {
  id: string;
  content: string;
  confirm: () => void;
  dialogProps: DialogProps;

  constructor(content: string, confirm: () => void, dialogProps: DialogProps = {} as DialogProps) {
    this.id = self.crypto.randomUUID();
    this.content = content;
    this.confirm = confirm;
    this.dialogProps = dialogProps;
  }

  static new(content: string, confirm: () => void, dialogProps: DialogProps = {} as DialogProps) {
    return new AlertModel(content, confirm, dialogProps);
  }
}

export default AlertModel;
