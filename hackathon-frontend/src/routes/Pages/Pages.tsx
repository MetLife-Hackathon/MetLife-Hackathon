import { Route, Routes, useLocation } from 'react-router-dom';

import Box from '@mui/material/Box';

import routes from '..';
import { getPageHeight } from './utils';
import Header from '@/sections/Header';
import Sidebar from '@/sections/Sidebar';

function Pages() {
  const location = useLocation();

  return (
    <>
      {location.pathname != '/' && <Header />}
      {location.pathname != '/' && <Sidebar />}
      <Box sx={{ height: (theme) => getPageHeight(theme) }}>
        <Routes>
          {Object.values(routes).map(({ path, component: Component }) => {
            return <Route key={path} path={path} element={<Component />} />;
          })}
        </Routes>
      </Box>
    </>
  );
}

export default Pages;
