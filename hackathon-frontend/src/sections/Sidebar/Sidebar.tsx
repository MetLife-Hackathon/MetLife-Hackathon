import { Link, useNavigate } from 'react-router-dom';

import DefaultIcon from '@mui/icons-material/Deblur';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import SwipeableDrawer from '@mui/material/SwipeableDrawer';
import { IconButton } from '@mui/material';

import routes from '@/routes';
import useSidebar from '@/store/sidebar';

function Sidebar() {
  const [isSidebarOpen, sidebarActions] = useSidebar();

  const navigate = useNavigate();

  return (
    <SwipeableDrawer
      anchor="left"
      open={isSidebarOpen}
      onClose={sidebarActions.close}
      onOpen={sidebarActions.open}
    >
      <List className="flex flex-col p-6 mx-auto w-full bg-white max-w-[480px]">
        <ListItem className="flex flex-col pb-16">
          <div className="flex gap-5">
            <div className="flex flex-1 gap-3">
              <img
                loading="lazy"
                src="https://cdn.builder.io/api/v1/image/assets/TEMP/a8b23b93aa26af30ff85ce50d4cb092c45d55262ae19cf0bc26c09d65aad13b0?apiKey=5752170bdb8e46caac8bb4ae4a027e87&"
                className="shrink-0 w-12 aspect-square"
              />
              <div className="flex flex-col flex-1 my-auto">
                <div className="text-base font-semibold tracking-normal leading-6 text-gray-900">
                  Andrew Lee
                </div>
                <div className="text-xs font-medium tracking-normal leading-3 text-gray-600">
                  client
                </div>
              </div>
            </div>
            <div className="flex flex-col justify-center my-auto">
              <div className="flex justify-center items-center">
                <IconButton onClick={() => navigate('/')}>
                  <img
                    loading="lazy"
                    src="https://cdn.builder.io/api/v1/image/assets/TEMP/2d6f6f718700069b5d6284a8aac3433a9b6f661033ae21b296e1653e39ddfcdf?apiKey=5752170bdb8e46caac8bb4ae4a027e87&"
                    className="w-6 aspect-square"
                  />
                </IconButton>
              </div>
            </div>
          </div>
        </ListItem>
        <div className="flex flex-col mt-8 text-base font-semibold tracking-normal leading-6 text-gray-600">
          {Object.values(routes)
            .filter((route) => route.title)
            .map(({ path, title, icon: Icon }) => (
              <ListItemButton
                className="p-3 mt-2 whitespace-nowrap rounded-lg"
                key={path}
                component={Link}
                to={path as string}
                onClick={sidebarActions.close}
              >
                <div className="flex flex-col justify-center">
                  <div className="flex gap-1.5">
                    <ListItemIcon>{Icon ? <Icon /> : <DefaultIcon />}</ListItemIcon>
                    <ListItemText primary={title} />
                  </div>
                </div>
              </ListItemButton>
            ))}
        </div>
      </List>
    </SwipeableDrawer>
  );
}

export default Sidebar;
