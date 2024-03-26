import React, { ReactNode } from 'react';

interface ContainerProps {
  children: ReactNode;
}

const PromptAdviceContainer = ({ children }: ContainerProps) => {
  return <>{children}</>;
};

export default PromptAdviceContainer;
