import Meta from '@/components/Meta';
import { FullSizeCenteredFlexBox } from '@/components/styled';
import { Grid, Typography } from '@mui/material';
import { MemberDataTable } from '@/components/Table/indx';

function Page1() {
  return (
    <>
      <Meta title="customers" />
      <FullSizeCenteredFlexBox>
        <Grid container spacing={1} justifyContent="center" width="80vw">
          <Grid item md={12}>
            <Typography fontWeight={600} fontSize="25px">
              상담신청 고객 현황
            </Typography>
          </Grid>
          <Grid item md={12}>
            <MemberDataTable />
          </Grid>
        </Grid>
      </FullSizeCenteredFlexBox>
    </>
  );
}

export default Page1;
