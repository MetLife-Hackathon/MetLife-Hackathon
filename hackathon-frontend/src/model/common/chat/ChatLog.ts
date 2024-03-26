import { Speaker } from '@/model/common/chat/Speaker';
import moment, { Moment } from 'moment';

class ChatLog {
  text: string;
  timestamp: Moment;
  speakerType: Speaker;

  constructor(text: string, speakerType: Speaker) {
    this.text = text;
    this.timestamp = moment();
    this.speakerType = speakerType;
  }

  static new(text: string, speakerType: Speaker) {
    return new ChatLog(text, speakerType);
  }
}

export default ChatLog;
