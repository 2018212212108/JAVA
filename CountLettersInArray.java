����   8 p  unit7/CountLettersInArray  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lunit7/CountLettersInArray; main ([Ljava/lang/String;)V
     createArray ()[C	    java/lang/System   out Ljava/io/PrintStream;  The lowercase letters are:
    java/io/PrintStream   ! println (Ljava/lang/String;)V
  # $ % displayArray ([C)V
  ' ( ) countLetters ([C)[I
  +    - #The occurrences of each letter are:
  / 0 1 displayCounts ([I)V args [Ljava/lang/String; chars [C counts [I
  9 : ; getRandomLowerCaseLetter ()C i I StackMapTable 5 getRandomCharacter (CC)C
 C E D java/lang/Math F G random ()D ch1 C ch2
  L @ A
  N   O (C)V Q java/lang/StringBuilder
 S U T java/lang/String V W valueOf (C)Ljava/lang/String;
 P Y  ! [  
 P ] ^ _ append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 P a b c toString ()Ljava/lang/String;
  e f ! print 7
 S i V j (I)Ljava/lang/String;
 P l ^ m (C)Ljava/lang/StringBuilder; 
SourceFile CountLettersInArray.java !               /     *� �    
                    	       �     (� L� � +� "+� &M� � *� ,� ,� .�    
   "      
         #  '          ( 2 3    $ 4 5    6 7  	       o     d�K<� *� 8U�*����*�    
          
             4 5     < =  >   
 � 
 ? 	 @ A     D     �� Bd`�kc���    
                H I      J I  	 : ;     (      az� K�    
       #       	 $ %     �     ?<� 6`p� � *4� M� � � PY*4� R� XZ� \� `� d�*���ʱ    
       '  (  )  *  + 5 ' > .        ? 4 5    < < =  >   	 �  	 ( )          !�
L=� +*4ad\.`O�*����+�    
       1  3 
 4  3  6         ! 4 5     6 7    < =  >   
 � 
 g 	 0 1     �     f<� ]`
p� )� � PY*.� h� XZ� \a`�� k� `� � +� � PY*.� h� XZ� \a`�� kZ� \� `� d�*�����    
       :  ;  < 1 = 4 > \ : e A        f 6 7    c < =  >   	 � .'  n    o