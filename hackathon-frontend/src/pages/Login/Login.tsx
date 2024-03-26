import * as React from 'react';
import { useEffect, useState } from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { axiosApi } from '@/utils/axios';
import { useNavigate } from 'react-router-dom';
import useNotifications from '@/store/notifications';

type LoginField = {
  email: string;
  password: string;
};

const Login = () => {
  const [field, setField] = useState<LoginField>({
    email: '',
    password: '',
  });
  const [loginButtonDisabled, setLoginButtonDisabled] = useState<boolean>(true);
  const navigate = useNavigate();
  const [, notificationsActions] = useNotifications();

  const handleEmailChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const updated = { ...field };
    updated.email = event.currentTarget.value;
    setField(updated);
  };

  const handlePasswordChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const updated = { ...field };
    updated.password = event.currentTarget.value;
    setField(updated);
  };

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    console.log({
      email: data.get('email'),
      password: data.get('password'),
    });

    try {
      const response = await axiosApi.post(
        'https://app-metlife-team10.azurewebsites.net/members/login',
        field,
      );

      if (response.status === 204) {
        console.log('Login Request Success');
        navigate('/welcome');
      }
    } catch (e) {
      notificationsActions.push({
        options: {
          autoHideDuration: 4500,
          variant: 'error',
        },
        message: '로그인 오류! 다시 확인해 주세요.',
      });
    }
  };

  useEffect(() => {
    if (field.email.trim().length > 0 && field.password.trim().length > 0) {
      setLoginButtonDisabled(false);
    } else {
      setLoginButtonDisabled(true);
    }
  }, [field]);

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <Box
        sx={{
          marginTop: 8,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
        }}
      >
        <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Log In
        </Typography>
        <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
          <TextField
            margin="normal"
            required
            fullWidth
            id="email"
            label="이메일 주소"
            name="email"
            onChange={handleEmailChange}
            autoComplete="email"
            autoFocus
          />
          <TextField
            margin="normal"
            required
            fullWidth
            name="password"
            label="비밀번호"
            type="password"
            id="password"
            onChange={handlePasswordChange}
            autoComplete="current-password"
          />
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            size="large"
            disabled={loginButtonDisabled}
            sx={{
              mt: 3,
              mb: 2,
              background: 'linear-gradient(90deg, #0090DA 30%, #A4CE4E 80%)',
              '&.Mui-disabled': {
                background: 'unset',
                backgroundColor: 'rgba(0,0,0,0.12)',
              },
            }}
          >
            로그인
          </Button>
          <Grid container justifyContent="flex-end">
            <Grid item container justifyContent="space-between">
              <Grid item>
                <Link href="/customers" variant="body2">
                  (상담사 화면 보기)
                </Link>
              </Grid>
              <Grid item>
                <Link href="/signup" variant="body2">
                  계정이 없으신가요? 회원가입하기
                </Link>
              </Grid>
            </Grid>
          </Grid>
        </Box>
      </Box>
    </Container>
  );
};

export default Login;
