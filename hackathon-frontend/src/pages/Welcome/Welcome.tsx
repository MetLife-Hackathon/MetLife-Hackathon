import { FullSizeCenteredFlexBox } from '@/components/styled';
import { Grid } from '@mui/material';
import ChatContainer from '../../components/Chat/ChatContainer';

function Welcome() {
  return (
    <>
      <FullSizeCenteredFlexBox>
        <Grid container spacing={1} justifyContent="center" mt={7} pb={7}>
          <Grid item md={10} justifyContent="center" width="100%" height="500px">
            <ChatContainer />
          </Grid>
        </Grid>
      </FullSizeCenteredFlexBox>
    </>
  );
}

export default Welcome;
