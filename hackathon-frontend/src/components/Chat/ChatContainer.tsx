import React, { useMemo, useState } from 'react';
import ChatInput from '@/components/Chat/ChatInput';
import MessageBar from '@/components/Chat/MessageBar';
import PromptAdviceContainer from '@/components/Chat/PromptAdviceContainer';
import PromptComponent from '@/components/Chat/PromptComponent';
import { Box } from '@mui/system';
import { Button, Grid } from '@mui/material';
import useChatLogStore from '@/store/common/chat';
import { axiosApi } from '@/utils/axios';
import useDialog from '@/hooks/useDialog';
import { Virtuoso } from 'react-virtuoso';
import { Speaker } from '@/model/common/chat';

const ChatContainer: React.FC = () => {
  const { chatLogModels } = useChatLogStore();
  const { alert } = useDialog();
  const [inputText, setInputText] = useState<string>('');

  const handleRequestConsultation = async () => {
    const history = chatLogModels.reduce((prev, curr) => {
      return prev + `;${curr.speakerType === Speaker.Ai ? '상담사' : '고객'}:${curr.text}`;
    }, '');

    const result = await axiosApi
      .post<{ history: string; question: string }, { consultantName: string }>('/consultings', {
        history,
        question: inputText,
      })
      .finally(() => {
        setInputText('');
      });

    await alert(`상담사 ${result.data.consultantName} 님이 배정되었습니다.`);
  };

  const noModels = useMemo(() => chatLogModels.length === 0, [chatLogModels]);

  return (
    <Box>
      <Grid>
        <Grid item>
          <PromptAdviceContainer>
            <PromptComponent setInputText={setInputText} />
          </PromptAdviceContainer>
        </Grid>
        <Grid item>
          {!noModels && (
            <Virtuoso
              style={{ height: '60vh' }}
              data={chatLogModels}
              followOutput="smooth"
              itemContent={(idx, model) => (
                <MessageBar
                  key={`chat-message-key${idx}`}
                  speaker={model.speakerType}
                  text={model.text}
                  timestamp={model.timestamp}
                />
              )}
            />
          )}
        </Grid>
        <Grid item container paddingTop={4} spacing={2}>
          {!noModels && (
            <Grid md={2} pt={2} justifySelf="center">
              <Button
                onClick={handleRequestConsultation}
                fullWidth
                variant="contained"
                size="large"
                style={{
                  height: '56px',
                  borderRadius: '56px',
                  background: '-webkit-linear-gradient(45deg, #0090DA 30%, #A4CE4E 80%)',
                }}
              >
                상담 신청하기
              </Button>
            </Grid>
          )}
          <Grid item md={noModels ? 12 : 10}>
            <ChatInput inputText={inputText} setInputText={setInputText} />
          </Grid>
        </Grid>
      </Grid>
    </Box>
  );
};

export default ChatContainer;
