import React from 'react';
import { Box, Button, Typography } from '@mui/material';
import useChatLogStore from '@/store/common/chat';

const options = [
  {
    keyword: '무배당 종신보험',
    text: '연 100만원의 비용정도가 드는 보험으로, 종신보험이면 좋겠어. 내가 다칠때마다 보험금을 줬으면 좋겠고,다른 보험들과 연관이 없었으면 좋겠어. 무배당이었으면 좋겠어.',
  },
  {
    keyword: '요양 병원',
    text:
      '나는 70세 노인이야. 자식이 두명 있고 내가 요양 병원에 가기 위한 지원금을 받을 수 있는 상품이 있을까 싶어.\n' +
      '국가에서 내가 요양병원에 들어갈 때 지원해주는 지원금이 있을텐데 한 70만원 정도로 생각이 돼.\n' +
      '자식은 두명이 있고 각각 남자와 여자야. 남편은 2년 전에 먼저 세상을 떠났어.',
  },
  {
    keyword: '교통사고',
    text:
      '나는 대학교에서 대학원을 다니는 대학원생이야. 나는 30살이고 어제 교통사고가 나서 다리를 크게 다쳤어.\n' +
      '병원에서는 보험금을 얼마나 받을 수 있는지 알아보라고 했어. 나는 전치 20주 진단을 받았고, 병원비가 많이 나갈것 같아.\n' +
      '나는 기존에 교통사고 관련 보험을 들어놓지 않았어. 다만 어릴때 무배당키즈드림변액유니버셜 보험을 들어놨어.\n' +
      '무배당e수술보장대출상환신용보험을 2년째 들고 있기도 해. 나 보험금 얼마나 받을 수 있을까?',
  },
  {
    keyword: '암',
    text:
      '나는 25살이야. 얼마전에 무배당100세시대실버암보험을 가입했어. 어제 암에 걸렸다는 이야기를 병원에서 들었어.\n' +
      '나는 부모님이 두분 다 살아계시고, 대학교를 다니고 있고, 23세 여동생이 하나 있어. 10살 때병원에서 맹장수술을 한번 한적이 있고, 그 때 보험금은 따로 받지 않았어. 나 보험금을 얼마나 받을 수 있을까? 나한테 추천해줄 보험이 있어?',
  },
];
const userName = '사용자'; // 사용자 이름은 동적으로 설정되어야 합니다.

interface Props {
  setInputText: (value: string) => void;
}

const PromptComponent: React.FC<Props> = ({ setInputText }) => {
  const { chatLogModels } = useChatLogStore();

  const handleSelect = (index: number, text: string) => {
    setInputText(text);
  };

  return (
    <>
      {chatLogModels.length === 0 && (
        <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
          <Typography
            variant="h4"
            gutterBottom
            style={{
              background: '-webkit-linear-gradient(45deg, #0090DA 30%, #A4CE4E 80%)',
              WebkitBackgroundClip: 'text',
              WebkitTextFillColor: 'transparent',
            }}
          >
            {userName}님, 안녕하세요
          </Typography>
          <Typography variant="h4" gutterBottom>
            무엇을 도와드릴까요?
          </Typography>
          <Typography textAlign="center" mt={2} sx={{ fontStyle: 'italic' }}>
            아래와 같은 질문을 해보세요
          </Typography>
          <Box sx={{ display: 'flex', justifyContent: 'center', gap: 2, mt: 4 }}>
            {options.map((option, index) => (
              <Button
                sx={{
                  // background: '#0090DA',
                  width: '200px',
                  height: '150px',
                  borderRadius: '16px',
                }}
                key={option.keyword}
                variant={'outlined'}
                color="primary"
                onClick={() => handleSelect(index, option.text)}
              >
                <Typography textAlign="center">{option.keyword}</Typography>
              </Button>
            ))}
          </Box>
        </Box>
      )}
    </>
  );
};

export default PromptComponent;
