import React, { useEffect, useState } from 'react';
import { Card, CardActions, CardContent, Grid } from '@mui/material';
import { Speaker } from '@/model/common/chat';
import { Moment } from 'moment';
import Typography from '@mui/material/Typography';

interface Props {
  speaker: Speaker;
  text: string;
  timestamp: Moment;
}

const MessageBar: React.FC<Props> = ({ speaker, text, timestamp }) => {
  const className = speaker !== Speaker.Ai ? 'flex justify-end' : 'flex justify-start';
  const color = speaker !== Speaker.Ai ? 'white' : '#A4CE4E';

  const [time, setTime] = useState('');

  useEffect(() => {
    // const just = moment().diff(timestamp, 'minute') < 5;

    const formatted = timestamp.format('hh:mm');
    setTime(formatted);
  }, [timestamp]);

  return (
    <Grid item className={className}>
      <Card
        sx={{ borderRadius: '12px', width: 'inherit', backgroundColor: color }}
        className="mt-5 flex"
      >
        <CardContent>
          {text.split('\n').map((txt, index) => {
            return <Typography key={`textSplit-${txt}-${index}`}>{txt}</Typography>;
          })}
        </CardContent>
        <CardActions>
          <div style={{ fontSize: '10px' }}>{time}</div>
        </CardActions>
      </Card>
    </Grid>
  );
};

export default MessageBar;
