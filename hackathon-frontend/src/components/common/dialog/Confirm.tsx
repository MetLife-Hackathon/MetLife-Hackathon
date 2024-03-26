import React from 'react';
import { Button, Dialog, DialogActions, DialogContent, DialogProps } from '@mui/material';

interface Props {
  content: string;
  dialogProps?: DialogProps;
  onConfirm: (value: boolean) => void;
  onClose: () => void;
}

const Confirm: React.FC<Props> = ({ content, dialogProps, onClose, onConfirm }) => {
  const handleConfirm = () => {
    onConfirm(true);
    onClose();
  };

  const handleClose = () => {
    onConfirm(false);
    onClose();
  };

  return (
    <Dialog open={true} onClose={onClose} {...dialogProps} fullWidth maxWidth="sm">
      <DialogContent>
        <div className="flex flex-col pt-10 w-full">
          <div className="flex flex-col px-12 w-full max-md:px-5 max-md:max-w-full">
            <div className="flex gap-5 max-md:flex-wrap">
              <div className="flex justify-center items-center px-4 pt-0.5 bg-red-100 h-[54px] rounded-[60px] w-[54px]">
                <img
                  loading="lazy"
                  src="https://cdn.builder.io/api/v1/image/assets/TEMP/053f0081ac3e7aaed43d81bcc5b796ebfa7b0c614c131da18805c7be235951bd?apiKey=5752170bdb8e46caac8bb4ae4a027e87&"
                  className="aspect-[1.32] fill-emerald-500 w-[21px]"
                />
              </div>
              <div className="my-auto text-2xl font-bold text-black text-opacity-90">
                Congratulations!
              </div>
            </div>
            <div className="flex flex-col justify-center mt-8 text-base text-black text-opacity-60 max-md:max-w-full">
              <div className="justify-center max-md:max-w-full">{content}</div>
            </div>
          </div>
        </div>
      </DialogContent>
      <DialogActions>
        <div className="flex gap-5 self-end p-8 text-base font-medium tracking-wide leading-7 uppercase whitespace-nowrap max-md:px-5">
          <Button variant="outlined" color="primary" fullWidth onClick={handleClose}>
            취소
          </Button>
          <Button variant="contained" color="primary" fullWidth onClick={handleConfirm}>
            확인
          </Button>
        </div>
      </DialogActions>
    </Dialog>
  );
};

export default Confirm;
