// import Typography from '@mui/material/Typography';

// import Meta from '@/components/Meta';
// import { FullSizeCenteredFlexBox } from '@/components/styled';

// function Page3() {
//   return (
//     <>
//       <Meta title="page 3" />
//       <FullSizeCenteredFlexBox>
//         <Typography variant="h3">Page 3</Typography>
//       </FullSizeCenteredFlexBox>
//     </>
//   );
// }

// export default Page3;

import React, { useState } from 'react';
import { Box, Button, Typography } from '@mui/material';

const options = ['유튜브 채널 빌딩', '정책 추적', '운영사', '업무 자동화'];
const userName = '사용자'; // 사용자 이름은 동적으로 설정되어야 합니다.

const ToggleButtons = () => {
  const [selectedIndex, setSelectedIndex] = useState<number | null>(null);

  const handleSelect = (index: number) => {
    setSelectedIndex(index);
    console.log(`버튼 ${index + 1}이 선택됨`); // 선택된 버튼의 위치(인덱스 + 1) 값을 콘솔에 출력
  };

  return (
    <>
      <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', p: 2 }}>
        <Typography variant="h4" gutterBottom>
          {userName}님, 환영합니다!
        </Typography>
        <Box sx={{ display: 'flex', justifyContent: 'center', gap: 2, mt: 4 }}>
          {options.map((option, index) => (
            <Button
              key={option}
              variant={selectedIndex === index ? 'contained' : 'outlined'}
              onClick={() => handleSelect(index)}
              sx={{ width: '150px', height: '150px', borderRadius: '16px' }}
            >
              <Typography textAlign="center">{option}</Typography>
            </Button>
          ))}
        </Box>
        {selectedIndex !== null && (
          <Typography textAlign="center" mt={2}>
            버튼 {selectedIndex + 1}이 선택됨
          </Typography>
        )}
      </Box>
    </>
  );
};

export default ToggleButtons;
