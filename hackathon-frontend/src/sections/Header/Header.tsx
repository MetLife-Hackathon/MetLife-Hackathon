import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Toolbar from '@mui/material/Toolbar';
import LogoutIcon from '@mui/icons-material/Logout';

import { FlexBox } from '@/components/styled';
import { title } from '@/config';
import useTheme from '@/store/theme';
import { Divider, IconButton, Tooltip, Typography } from '@mui/material';
import { useNavigate } from 'react-router-dom';

function Header() {
  const [theme] = useTheme();
  const navigate = useNavigate();

  return (
    <Box sx={{ flexGrow: 1 }} data-pw={`theme-${theme}`} className="bg-white">
      <AppBar color="transparent" elevation={0} position="static">
        <Toolbar sx={{ justifyContent: 'space-between' }}>
          <FlexBox sx={{ alignItems: 'center' }}>
            <Button color="info" size="large">
              {title}
            </Button>
          </FlexBox>
          <FlexBox>
            <Divider orientation="vertical" flexItem />
            <Tooltip title="It's open source" arrow>
              <IconButton
                color="info"
                size="small"
                component="a"
                onClick={() => navigate('./')}
                target="_blank"
              >
                <LogoutIcon />
                <Typography fontSize="15px">Logout</Typography>
              </IconButton>
            </Tooltip>
          </FlexBox>
        </Toolbar>
      </AppBar>
    </Box>
  );
}

export default Header;
