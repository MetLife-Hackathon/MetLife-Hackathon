import { atom, useRecoilState } from 'recoil';
import { ChatLog, Speaker } from '@/model/common/chat';

const chatLogState = atom<ChatLog[]>({
  key: 'chat-log-state',
  default: [],
});

const useChatLogStore = () => {
  const [chatLogModels, setChatLogModels] = useRecoilState(chatLogState);

  const addUserChat = (text: string) => {
    const chat = ChatLog.new(text, Speaker.Customer);
    setChatLogModels([...chatLogModels, chat]);
  };

  const addAIChat = (text: string) => {
    const chat = ChatLog.new(text, Speaker.Ai);
    console.log([...chatLogModels, chat]);
    setChatLogModels((prev) => [...prev, chat]);
  };

  return {
    chatLogModels,
    addUserChat,
    addAIChat,
  };
};

export default useChatLogStore;
